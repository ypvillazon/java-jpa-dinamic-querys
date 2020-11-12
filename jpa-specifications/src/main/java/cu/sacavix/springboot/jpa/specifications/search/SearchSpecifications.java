package cu.sacavix.springboot.jpa.specifications.search;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SearchSpecifications<T> implements Specification<T> {

    private List<SearchCriteria> searchCriteriaList;

    public SearchSpecifications() {
        this.searchCriteriaList = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {
        searchCriteriaList.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : searchCriteriaList)
            if (criteria.getSearchOperation().equals(SearchOperation.GREATER_THAN))
                predicates.add(builder.greaterThan(root.get(criteria.getAttr()), criteria.getValue().toString()));
            else
                if (criteria.getSearchOperation().equals(SearchOperation.LESS_THAN))
                    predicates.add(builder.lessThan(root.get(criteria.getAttr()), criteria.getValue().toString()));
                else
                    if (criteria.getSearchOperation().equals(SearchOperation.GREATER_THAN_EQUAL))
                        predicates.add(builder.greaterThanOrEqualTo(root.get((criteria.getAttr())), criteria.getValue().toString()));
                    else
                        if (criteria.getSearchOperation().equals(SearchOperation.LESS_THAN_EQUAL))
                            predicates.add(builder.lessThanOrEqualTo(root.get(criteria.getAttr()), criteria.getValue().toString()));
                        else
                            if (criteria.getSearchOperation().equals(SearchOperation.NOT_EQUAL))
                                predicates.add(builder.notEqual(root.get(criteria.getAttr()), criteria.getValue()));
                            else
                                if (criteria.getSearchOperation().equals(SearchOperation.EQUAL))
                                    predicates.add(builder.equal(root.get(criteria.getAttr()), criteria.getValue()));
                                else
                                    if (criteria.getSearchOperation().equals(SearchOperation.MATCH))
                                        predicates.add(builder.like(builder.lower(root.get(criteria.getAttr())),"%" + criteria.getValue().toString().toLowerCase() + "%"));
                                    else
                                        if (criteria.getSearchOperation().equals(SearchOperation.MATCH_END))
                                            predicates.add(builder.like(builder.lower(root.get(criteria.getAttr())),criteria.getValue().toString().toLowerCase() + "%"));
                                        else
                                            if (criteria.getSearchOperation().equals(SearchOperation.MATCH_START))
                                                predicates.add(builder.like(builder.lower(root.get(criteria.getAttr())), "%" + criteria.getValue().toString().toLowerCase()));
                                            else
                                                if (criteria.getSearchOperation().equals(SearchOperation.IN))
                                                    predicates.add(builder.in(root.get(criteria.getAttr())).value(criteria.getValue()));
                                                else
                                                    if (criteria.getSearchOperation().equals(SearchOperation.NOT_IN))
                                                        predicates.add(builder.not(root.get(criteria.getAttr())).in(criteria.getValue()));

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}


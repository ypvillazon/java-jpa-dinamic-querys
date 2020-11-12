package cu.sacavix.springboot.jpa.specifications.search;

public class SearchCriteria {

    private String attr;
    private Object value;
    private SearchOperation searchOperation;

    public SearchCriteria() {}

    public SearchCriteria(String attr, Object value, SearchOperation searchOperation) {
        this.attr = attr;
        this.value = value;
        this.searchOperation = searchOperation;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public SearchOperation getSearchOperation() {
        return searchOperation;
    }

    public void setSearchOperation(SearchOperation searchOperation) {
        this.searchOperation = searchOperation;
    }
}

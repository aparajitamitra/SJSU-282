package espproject;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "completed_in",
    "max_id",
    "max_id_str",
    "next_results",
    "query",
    "refresh_url",
    "count",
    "since_id",
    "since_id_str"
})
public class SearchMetadata {

    @JsonProperty("completed_in")
    private Double completedIn;
    @JsonProperty("max_id")
    private Long maxId;
    @JsonProperty("max_id_str")
    private String maxIdStr;
    @JsonProperty("next_results")
    private String nextResults;
    @JsonProperty("query")
    private String query;
    @JsonProperty("refresh_url")
    private String refreshUrl;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("since_id")
    private Long sinceId;
    @JsonProperty("since_id_str")
    private String sinceIdStr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The completedIn
     */
    @JsonProperty("completed_in")
    public Double getCompletedIn() {
        return completedIn;
    }

    /**
     * 
     * @param completedIn
     *     The completed_in
     */
    @JsonProperty("completed_in")
    public void setCompletedIn(Double completedIn) {
        this.completedIn = completedIn;
    }

    /**
     * 
     * @return
     *     The maxId
     */
    @JsonProperty("max_id")
    public Long getMaxId() {
        return maxId;
    }

    /**
     * 
     * @param maxId
     *     The max_id
     */
    @JsonProperty("max_id")
    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    /**
     * 
     * @return
     *     The maxIdStr
     */
    @JsonProperty("max_id_str")
    public String getMaxIdStr() {
        return maxIdStr;
    }

    /**
     * 
     * @param maxIdStr
     *     The max_id_str
     */
    @JsonProperty("max_id_str")
    public void setMaxIdStr(String maxIdStr) {
        this.maxIdStr = maxIdStr;
    }

    /**
     * 
     * @return
     *     The nextResults
     */
    @JsonProperty("next_results")
    public String getNextResults() {
        return nextResults;
    }

    /**
     * 
     * @param nextResults
     *     The next_results
     */
    @JsonProperty("next_results")
    public void setNextResults(String nextResults) {
        this.nextResults = nextResults;
    }

    /**
     * 
     * @return
     *     The query
     */
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 
     * @return
     *     The refreshUrl
     */
    @JsonProperty("refresh_url")
    public String getRefreshUrl() {
        return refreshUrl;
    }

    /**
     * 
     * @param refreshUrl
     *     The refresh_url
     */
    @JsonProperty("refresh_url")
    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
    }

    /**
     * 
     * @return
     *     The count
     */
    @JsonProperty("count")
    public Long getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    @JsonProperty("count")
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The sinceId
     */
    @JsonProperty("since_id")
    public Long getSinceId() {
        return sinceId;
    }

    /**
     * 
     * @param sinceId
     *     The since_id
     */
    @JsonProperty("since_id")
    public void setSinceId(Long sinceId) {
        this.sinceId = sinceId;
    }

    /**
     * 
     * @return
     *     The sinceIdStr
     */
    @JsonProperty("since_id_str")
    public String getSinceIdStr() {
        return sinceIdStr;
    }

    /**
     * 
     * @param sinceIdStr
     *     The since_id_str
     */
    @JsonProperty("since_id_str")
    public void setSinceIdStr(String sinceIdStr) {
        this.sinceIdStr = sinceIdStr;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

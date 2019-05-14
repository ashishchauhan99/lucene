package org.kumar.lucene.query;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;

public class TermRangeQueryDemo {

    public void createTermRangeQueryDemo() {
        Term term = new Term("name", "edureka");
        Query query = new TermQuery(term);
    }
}

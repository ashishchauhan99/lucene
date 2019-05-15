package org.kumar.lucene.query;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.BooleanQuery.Builder;
import org.apache.lucene.search.TermQuery;

public class BooleanQueryDemo {

    public void testBooleanQeury() throws Exception {
        Builder builder = new BooleanQuery.Builder();

        TermQuery termQuery1 = new TermQuery(new Term("content", "java"));
        TermQuery termQuery2 = new TermQuery(new Term("content", "net"));
        TermQuery termQuery3 = new TermQuery(new Term("content", "php"));
        TermQuery termQuery4 = new TermQuery(new Term("company", "weclapp"));

        builder.add(new BooleanClause(termQuery1, Occur.MUST));
        builder.add(new BooleanClause(termQuery2, Occur.MUST));
        builder.add(new BooleanClause(termQuery3, Occur.MUST_NOT));
        builder.add(new BooleanClause(termQuery4, Occur.MUST));

        BooleanQuery booleanQuery = builder.build();
    }
}

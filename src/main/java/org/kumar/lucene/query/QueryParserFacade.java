package org.kumar.lucene.query;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TopDocs;

public class QueryParserFacade {

    private IndexSearcher indexSearcher;
    private QueryParser queryParser;

    public QueryParserFacade(IndexSearcher indexSearcher, Analyzer analyzer) {
        this.indexSearcher = indexSearcher;
        this.queryParser = new QueryParser("", analyzer);
    }

    public TopDocs getTopDocs(String query) throws Exception {
        TopDocs topDocs = indexSearcher.search(queryParser.parse(query), 10);
        return topDocs;
    }

}

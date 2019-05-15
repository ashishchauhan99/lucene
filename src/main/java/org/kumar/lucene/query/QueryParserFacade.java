package org.kumar.lucene.query;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TopDocs;

public class QueryParserFacade {

    public TopDocs getTopDocs(String query, IndexSearcher indexSearcher, Analyzer analyzer) {
        QueryParser queryParser = new QueryParser(query, analyzer);

        return null;
    }

}

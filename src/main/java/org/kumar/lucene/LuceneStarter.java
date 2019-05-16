package org.kumar.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TopDocs;
import org.kumar.lucene.document.DocumentFacade;
import org.kumar.lucene.indexer.IndexSearcherFacade;
import org.kumar.lucene.indexer.IndexWriterFacade;
import org.kumar.lucene.query.QueryParserFacade;

public class LuceneStarter {

    final static String dataDir = "D:\\Lucene\\documents";
    final static String indexDir = "D:\\Lucene\\index";

    public static void main(String[] args) throws Exception {
        LuceneStarter luceneStarter = new LuceneStarter();
//        luceneStarter.createIndex();
        String query = "content:(apples OR edureka) AND name:file2*";
        luceneStarter.search(query);

    }

    private void createIndex() throws IOException {
        IndexWriterFacade indexWriterFacade = new IndexWriterFacade(indexDir, new StandardAnalyzer());
        DocumentFacade documentFacade = new DocumentFacade(dataDir);
        indexWriterFacade.createIndex(documentFacade.getPreparedDocuments());
    }

    private void search(String query) throws Exception {
        IndexSearcherFacade indexSearcherFacade = new IndexSearcherFacade(indexDir);
        IndexSearcher indexSearcher = indexSearcherFacade.getIndexSearcher();
        QueryParserFacade queryParserFacade = new QueryParserFacade(indexSearcher, new StandardAnalyzer());
        TopDocs topDocs = queryParserFacade.getTopDocs(query);

        long topHits = topDocs.totalHits.value;

        System.out.println("Total Hits: " + topHits);

        for (int i = 0; i < topHits; i++) {
            int docid = topDocs.scoreDocs[i].doc;
            Document doc = indexSearcher.doc(docid);
            String name = doc.get("name");
            System.out.println("Document field name:" + name);
        }
    }

}

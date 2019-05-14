package org.kumar.lucene.query;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;

/**
 * 
 * @author kumar
 *
 *         <ul>
 *         <li>used for retereiving documents by a key</li>
 *         </ul>
 */
public class TermQueryDemo {

    public void createTermQueryDemo() {
        Term term = new Term("name", "edureka");
        Query query = new TermQuery(term);
    }
}

package org.kumar.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.LetterTokenizer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;

/**
 * 
 * @author kumar
 * 
 *         split tokens at nonletter characters, only letters will be consider, everthing else will be ignored
 * 
 *         then {@link LetterTokenizer} with {@link LowerCaseFilter}
 * 
 * 
 */
public class SimpleAnalyzerDemo {

    public void createSimpleAnalyzerDemo() {
        Analyzer simpleAnalyzer = new SimpleAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(simpleAnalyzer);
    }

}

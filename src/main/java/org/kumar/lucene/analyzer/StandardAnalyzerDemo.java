package org.kumar.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.hi.HindiAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;

/**
 * 
 * @author kumar
 *         <ul>
 *         <li>StandardAnalyzer is most robust core analzer</li>
 *         <li>It has logic to identify certain tokens, such as company names, email addresses nd hostnames.</li>
 *         <li>It also lowercases each token and removes stop words (and, the, an) and punctuation (, ", !)</li>
 *         <li>Filters StandardTokenizer with Standard Filter, LowerCaseFilter and StopFilter (this list of words can be
 *         extendend)</li>
 *         <li>StandardAnalzer is for language English for other laguages jus use {@link HindiAnalyzer} the stop word
 *         list to StopFilter should be given externally</li>
 *         <li>To know the difference between {@ StandardAnalyzer} and {@link HindiAnalyzer} compare the method
 *         {@link HindiAnalyzer#createComponents}</li>
 *         </ul>
 * 
 *         <ul>
 *         <li>List of bad words can be created and given to StopFilter so they are not indexed and no searh could take
 *         palce based on those</li>
 *         </ul>
 */
public class StandardAnalyzerDemo {

    public void createStandardAnalyzerDemo() {
        Analyzer standardAnalyzer = new StandardAnalyzer();
        // Analyzer standardAnalyzerWithMoreStopWords = new StandardAnalyzer(new StringReader("Fuck"));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(standardAnalyzer);

    }

    public void createStandarHindiAnalzerDemo() {
        Analyzer hindiAnalyzer = new HindiAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(hindiAnalyzer);
    }

}

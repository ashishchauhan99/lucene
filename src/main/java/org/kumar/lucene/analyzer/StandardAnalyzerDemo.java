package org.kumar.lucene.analyzer;

import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.hi.HindiAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

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

    private static StandardAnalyzer standardAnalyzer;

    private StandardAnalyzerDemo() {
    }

    public static StandardAnalyzer getStandardAnalyzer() {

        if (standardAnalyzer == null) {

            Set<String> stopWords = new HashSet<String>();
            stopWords.add("Just");
            stopWords.add("Stop");
            stopWords.add("These");
            stopWords.add("Words");

            CharArraySet stopWordsCharArraySet = new CharArraySet(stopWords, true);

            /**
             * A reader can be passed which reads a file, each line in a file will be a stop words
             */
            standardAnalyzer = new StandardAnalyzer(stopWordsCharArraySet);
        }

        return standardAnalyzer;
    }

    public HindiAnalyzer getHindiAnalyzer() {
        return new HindiAnalyzer();
    }

}

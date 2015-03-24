package org.aksw.simba.cetus.preprocessing;

import org.aksw.simba.topicmodeling.preprocessing.docsupplier.DocumentSupplier;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.AbstractPropertyEditingDocumentSupplierDecorator;
import org.aksw.simba.topicmodeling.utils.doc.DocumentText;

public class QuotesRemovingSupplierDecorator extends AbstractPropertyEditingDocumentSupplierDecorator<DocumentText> {

    private QuotesRemovingAutomaton automaton = new QuotesRemovingAutomaton();

    public QuotesRemovingSupplierDecorator(DocumentSupplier documentSource) {
        super(documentSource, DocumentText.class);
    }

    @Override
    protected void editDocumentProperty(DocumentText text) {
        text.setText(automaton.removeQuotes(text.getText()));
    }

}

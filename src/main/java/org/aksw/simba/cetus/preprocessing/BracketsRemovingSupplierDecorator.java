package org.aksw.simba.cetus.preprocessing;

import org.aksw.simba.topicmodeling.preprocessing.docsupplier.DocumentSupplier;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.AbstractPropertyEditingDocumentSupplierDecorator;
import org.aksw.simba.topicmodeling.utils.doc.DocumentText;

public class BracketsRemovingSupplierDecorator extends AbstractPropertyEditingDocumentSupplierDecorator<DocumentText> {

    private BracketsRemovingAutomaton automaton = new BracketsRemovingAutomaton();

    public BracketsRemovingSupplierDecorator(DocumentSupplier documentSource) {
        super(documentSource, DocumentText.class);
    }

    @Override
    protected void editDocumentProperty(DocumentText text) {
        text.setText(automaton.removeBrackets(text.getText()));
    }

}

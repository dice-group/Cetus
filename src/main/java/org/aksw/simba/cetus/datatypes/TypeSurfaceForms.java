package org.aksw.simba.cetus.datatypes;

import java.util.List;

import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.simba.topicmodeling.utils.doc.AbstractSimpleDocumentProperty;

public class TypeSurfaceForms extends AbstractSimpleDocumentProperty<List<List<NamedEntity>>> {

    private static final long serialVersionUID = 1L;

    public TypeSurfaceForms(List<List<NamedEntity>> value) {
        super(value);
    }

}

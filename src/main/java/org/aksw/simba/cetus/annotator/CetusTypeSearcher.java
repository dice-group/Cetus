package org.aksw.simba.cetus.annotator;

import java.util.List;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.gerbil.transfer.nif.data.TypedNamedEntity;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;

public interface CetusTypeSearcher {

    public TypedNamedEntity getAllTypes(Document document, NamedEntity ne, List<ExtendedTypedNamedEntity> surfaceForms);

}

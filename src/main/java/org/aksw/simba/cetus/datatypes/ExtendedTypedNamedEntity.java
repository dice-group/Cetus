package org.aksw.simba.cetus.datatypes;

import java.util.Set;

import org.aksw.gerbil.transfer.nif.data.TypedNamedEntity;

public class ExtendedTypedNamedEntity extends TypedNamedEntity {

    private String label;

    public ExtendedTypedNamedEntity(int startPosition, int length, Set<String> uris, Set<String> types) {
        super(startPosition, length, uris, types);
    }

    public ExtendedTypedNamedEntity(int startPosition, int length, String uri, Set<String> types) {
        super(startPosition, length, uri, types);
    }

    public ExtendedTypedNamedEntity(int startPosition, int length, Set<String> uris, Set<String> types, String label) {
        super(startPosition, length, uris, types);
        this.label = label;
    }

    public ExtendedTypedNamedEntity(int startPosition, int length, String uri, Set<String> types, String label) {
        super(startPosition, length, uri, types);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

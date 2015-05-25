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
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ExtendedTypedNamedEntity other = (ExtendedTypedNamedEntity) obj;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        return true;
    }

}

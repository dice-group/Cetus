package org.aksw.simba.cetus.datatypes;


public class DescribedEntityType extends DescribedEntity {

    private static final long serialVersionUID = 1L;

    public DescribedEntityType(String label, String uri) {
        super(label, uri);
    }

    @Override
    public String toString() {
        return "DescribedEntityType=" + get().toString();
    }
}

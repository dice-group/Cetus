package org.aksw.simba.cetus.datatypes;

import org.aksw.simba.topicmodeling.utils.doc.AbstractDocumentProperty;

public class SimplePatternInTokenizedText extends AbstractDocumentProperty {

    private static final long serialVersionUID = 1L;

    private int start;
    private int end;
    private boolean startsWithEntity = true;

    public SimplePatternInTokenizedText(int start, int end, boolean startsWithEntity) {
        this.start = start;
        this.end = end;
        this.startsWithEntity = startsWithEntity;
    }

    public SimplePatternInTokenizedText(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Object getValue() {
        return new int[] { start, end };
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public boolean startsWithEntity() {
        return startsWithEntity;
    }

    public void setStartsWithEntity(boolean startsWithEntity) {
        this.startsWithEntity = startsWithEntity;
    }
}

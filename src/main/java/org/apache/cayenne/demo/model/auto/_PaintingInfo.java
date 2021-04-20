package org.apache.cayenne.demo.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.demo.model.Painting;
import org.apache.cayenne.exp.property.BaseProperty;
import org.apache.cayenne.exp.property.EntityProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.StringProperty;

/**
 * Class _PaintingInfo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _PaintingInfo extends BaseDataObject {

    private static final long serialVersionUID = 1L;

    public static final String PAINTING_ID_PK_COLUMN = "painting_id";

    public static final BaseProperty<byte[]> IMAGE = PropertyFactory.createBase("image", byte[].class);
    public static final StringProperty<String> REVIEW = PropertyFactory.createString("review", String.class);
    public static final EntityProperty<Painting> PAINTING = PropertyFactory.createEntity("painting", Painting.class);

    protected byte[] image;
    protected String review;

    protected Object painting;

    public void setImage(byte[] image) {
        beforePropertyWrite("image", this.image, image);
        this.image = image;
    }

    public byte[] getImage() {
        beforePropertyRead("image");
        return this.image;
    }

    public void setReview(String review) {
        beforePropertyWrite("review", this.review, review);
        this.review = review;
    }

    public String getReview() {
        beforePropertyRead("review");
        return this.review;
    }

    public void setPainting(Painting painting) {
        setToOneTarget("painting", painting, true);
    }

    public Painting getPainting() {
        return (Painting)readProperty("painting");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "image":
                return this.image;
            case "review":
                return this.review;
            case "painting":
                return this.painting;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "image":
                this.image = (byte[])val;
                break;
            case "review":
                this.review = (String)val;
                break;
            case "painting":
                this.painting = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.image);
        out.writeObject(this.review);
        out.writeObject(this.painting);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.image = (byte[])in.readObject();
        this.review = (String)in.readObject();
        this.painting = in.readObject();
    }

}
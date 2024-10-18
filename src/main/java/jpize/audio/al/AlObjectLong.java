package jpize.audio.al;

import jpize.util.Disposable;

public abstract class AlObjectLong implements Disposable {

    protected final long ID;

    public AlObjectLong(long ID) {
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(ID);
    }

    @Override
    public boolean equals(Object object) {
        if(this == object)
            return true;
        if(object == null || getClass() != object.getClass())
            return false;
        AlObjectLong alObject = (AlObjectLong) object;
        return ID == alObject.ID;
    }

}

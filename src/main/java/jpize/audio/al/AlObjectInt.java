package jpize.audio.al;

import jpize.audio.al.buffer.AlBuffer;
import jpize.util.Disposable;

public abstract class AlObjectInt implements Disposable {

    protected final int ID;

    public AlObjectInt(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        return ID;
    }


    public static int[] makeArray(AlObjectInt... objects) {
        final int[] buffer = new int[objects.length];
        for(int i = 0; i < objects.length; i++)
            buffer[i] = objects[i].ID;
        return buffer;
    }

}

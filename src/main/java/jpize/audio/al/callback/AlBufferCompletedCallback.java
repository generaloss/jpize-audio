package jpize.audio.al.callback;

public interface AlBufferCompletedCallback {

    void invoke(int sourceID, int bufferID);

}

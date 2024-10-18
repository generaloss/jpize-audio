package jpize.audio.al.callback;

@FunctionalInterface
public interface AlBufferCompletedCallback {

    void invoke(int sourceID, int bufferID);

}

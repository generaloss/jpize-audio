package jpize.audio.al.callback;

import jpize.audio.al.source.AlSourceState;

public interface AlSourceStateChangedCallback {

    void invoke(int sourceID, AlSourceState state);

}

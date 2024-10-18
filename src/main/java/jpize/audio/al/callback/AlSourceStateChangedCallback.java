package jpize.audio.al.callback;

import jpize.audio.al.source.AlSourceState;

@FunctionalInterface
public interface AlSourceStateChangedCallback {

    void invoke(int sourceID, AlSourceState state);

}

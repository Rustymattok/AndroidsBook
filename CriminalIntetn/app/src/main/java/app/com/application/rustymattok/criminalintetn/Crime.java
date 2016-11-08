package app.com.application.rustymattok.criminalintetn;

import java.util.UUID;
/**
 * Class describe Crime.
 * UUID - like individual indificator, the posibility for equel in this case too low.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        this.mId = UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}

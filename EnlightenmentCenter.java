package camelmanplayer;
import battlecode.common.RobotController;
import battlecode.common.GameActionException;

public class EnlightenmentCenter {
    public EnlightenmentCenter(final RobotController rc) {
        this.rc = rc;
    }

    public void run() throws GameActionException {

            bid();
    }

    private static final Bidder constantBidder = new ConstantBidder(1);
    private static final Bidder smallAdaptiveBidder = new LinearBidder(5, 5, 50);
    private static final Bidder mediumAdaptiveBidder = new LinearBidder(20, 20, 200);
    private static final Bidder largeAdaptiveBidder = new LinearBidder(50, 50, 1000);
    private final RobotController rc;
    private void bid() {
        final int influence = rc.getInfluence();

        if (influence < 200) {
            Apuesta.attemptBid(rc, constantBidder);
        } else if (influence < 500) {
            Apuesta.attemptBid(rc, smallAdaptiveBidder);
        } else if (influence < 1000) {
            Apuesta.attemptBid(rc, mediumAdaptiveBidder);
        } else {
            Apuesta.attemptBid(rc, largeAdaptiveBidder);
        }
    }
}

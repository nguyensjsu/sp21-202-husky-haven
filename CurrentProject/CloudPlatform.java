public class CloudPlatform extends AbstractPlatform {
    
    public CloudPlatform(float bounceForce) {
        super(bounceForce);
    }
    
    public void onBounce() {
        isDestroyed = true;
    }
}

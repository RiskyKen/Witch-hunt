package riskyken.witchHunt.proxies;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
        initRenderers();
    }

    @Override
    public void postInit() {
        super.postInit();
    }

    public void initRenderers() {

    }
}

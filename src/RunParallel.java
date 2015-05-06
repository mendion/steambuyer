import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class RunParallel {

	@Test
	public void runParallel() {
		Class[] cls={SteamBuyerItem1.class, SteamBuyerItem2.class};
		JUnitCore.runClasses(new ParallelComputer(true,false),cls);

	}
}

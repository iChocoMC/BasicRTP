package ichoco.basicrtp.methods;

import java.util.Random;

import org.bukkit.entity.Player;

import ichoco.basicrtp.BasicRtpMain;
import ichoco.basicrtp.utils.MethodUtil;

public class NegativeCords extends MethodUtil {

	private Random random = MethodUtil.Random();
	private int maxRadius = BasicRtpMain.getConfiguration().getInt("max-radius");

	public void preExecute(Player player) {
		int x = random.nextInt(maxRadius);
		int z = random.nextInt(maxRadius);
		int negative = random.nextInt(3);
		switch (negative){
			case 1: x = -x; break;
			case 2: z = -z; break;
			case 3:
				x = -x;
				z = -z;
			break;
		}
		super.execute(player, x, z);
	}
};
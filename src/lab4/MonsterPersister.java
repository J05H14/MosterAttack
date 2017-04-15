package lab4;

import java.io.File;
import java.util.List;

public interface MonsterPersister {

	public void saveListToFile(File f, List<MonsterAttack> a);
	public List<MonsterAttack> readListFromFile(File f);
}

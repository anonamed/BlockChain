import java.util.ArrayList;


public class TestChain {

	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	public static int difficulty = 5;
	public static int timedif;


	public static void main(String[] args) {		
		
		System.out.println("Trying to Mine block 1... ");
		addBlock(new Block("First block", "0"));

		System.out.println("Trying to Mine block 2... ");
		addBlock(new Block("Second block",blockchain.get(blockchain.size()-1).hash));
		
		System.out.println("Trying to Mine block 3... ");
		addBlock(new Block("Third block",blockchain.get(blockchain.size()-1).hash));

		System.out.println("Trying to Mine block 4... ");
		addBlock(new Block("Four block",blockchain.get(blockchain.size()-1).hash));
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
	}

	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);

			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}

			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}

			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
			
		}
		return true;
	}
	
	public static void addBlock(Block newBlock) {
		long debut = System.currentTimeMillis();

		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);

		timedif = Math.toIntExact(System.currentTimeMillis()-debut);
		System.out.println("Temps : "+timedif+" ms");

		if(timedif > 5000){
			difficulty = 5;
		} else if(timedif < 5000){
			difficulty = 6;
		} else {
			difficulty = 5;
		}
	}
}
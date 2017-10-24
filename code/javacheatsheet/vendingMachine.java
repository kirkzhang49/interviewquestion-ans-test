import java.util.ArrayList;

public class VendingMachine {
	private ArrayList<Item> itemlList;
	private ArrayList<Item> selectedItems;
	private Coin receivedCoin;	
	public VendingMachine(ArrayList<Item> itemlList) {
		this.itemlList = itemlList;
	}
	public ArrayList<Item> getItemlList() {
		return itemlList;
	}
	public ArrayList<Item> giveCoins(Coin coin){
		this.receivedCoin = coin;
		return showUserChoiceList();
	}
	private ArrayList<Item> showUserChoiceList() {
		ArrayList<Item> userChoiceList = new ArrayList<Item>();
		for(Item item: itemlList){			
			if(item.getPrice()<=receivedCoin.getValue()){
				userChoiceList.add(item);
			}
		}				
		return userChoiceList;
	}
	public Coin getSelectedItem(ArrayList<Item> selectedItems){
		this.selectedItems = selectedItems;
		return giveSelectedItem();
	}
	private Coin giveSelectedItem() {
		Coin returnCoin=null;
		double value = receivedCoin.getValue();
		for(Item item: selectedItems){
			System.out.println(item.getName()+" | "+item.getPrice());
			value=value-item.getPrice();
		}		
		return new Coin(value, receivedCoin.getCurrency());
	}
}
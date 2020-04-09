import java.util.ArrayList;
import java.util.Collections;

public class testcode {
	static class Account implements Comparable<Account> {
		String account, money;

		Account(String account, String money) {
			this.account = account;
			this.money = money;
		}

		@Override
		public int compareTo(Account o) {
			if (this.account.length() > o.account.length())
				return 1;
			else if (this.account.length() < o.account.length())
				return -1;
			else {
				for (int i = 0; i < account.length(); i++) {
					if (this.account.charAt(i) > o.account.charAt(i))
						return 1;
					else if (this.account.charAt(i) < o.account.charAt(i))
						return -1;
					else
						continue;
				}
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		String[][] snapshots = {
		                        {"ACCOUNT2", "150"},
		                        {"ACCOUNT1", "100"} 
		                      };
		String[][] transactions = {
		                           {"1", "SAVE", "ACCOUNT2", "100"},
		                           {"2", "WITHDRAW", "ACCOUNT1", "50"}, 
		                           {"1", "SAVE", "ACCOUNT2", "100"}, 
		                           {"4", "SAVE", "ACCOUNT3", "500"}, 
		                           {"3", "WITHDRAW", "ACCOUNT2", "30"}
		                         };
		
		ArrayList<Account> list = new ArrayList<>();
		for(int i = 0 ; i < snapshots.length ; i++) {
			list.add(new Account(snapshots[i][0],snapshots[i][1]));
		}
		boolean[] isUsed = new boolean[100001];
		for(int i = 0 ; i < transactions.length ; i++) {
			int n1 = Integer.parseInt(transactions[i][0]);
			if(!isUsed[n1]) {
				isUsed[n1] = true;
				if(transactions[i][1].equals("SAVE")) {
					boolean check = false;
					for(int j = 0 ; j < list.size() ; j++) {
						if(list.get(j).account.equals(transactions[i][2])) {
							check = true;
							int n2 = Integer.parseInt(list.get(j).money) + Integer.parseInt(transactions[i][3]);
							list.get(j).money = n2+"";
						}
					}
					if(!check) {
						list.add(new Account(transactions[i][2], transactions[i][3]));
					}
				}
				
				if(transactions[i][1].equals("WITHDRAW")) {
					for(int j = 0 ; j < list.size() ; j++) {
						if(list.get(j).account.equals(transactions[i][2])) {
							int n2 = Integer.parseInt(list.get(j).money) - Integer.parseInt(transactions[i][3]);
							list.get(j).money = n2+"";
						}
					}
				}
			}
		}
		Collections.sort(list);
		String[][] answer = new String[list.size()][2];
		int idx = 0;
		for(Account a : list) {
			System.out.println(a.account + " " + a.money);
			answer[idx][0] = a.account;
			answer[idx++][1] = a.money;
		}
	}
}

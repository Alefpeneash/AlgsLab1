class Hash{
  private String hashArr[];
  private int amount = -1;
  private int actualAmount = 0;

  Hash(int amount){
    this.hashArr = new String[amount];
    this.amount = amount;

  }

  public String[] get(){
    return hashArr;
  }

  public int add(String word){
    if (actualAmount == amount){
      return -1;
    }

    int hash =  hashFunc(word);
    if(hash > 0){
      actualAmount++;
      while(true){
        if (hashArr[hash] == null){
          hashArr[hash] = word;
          break;
        }
        else{
          hash = reHash(hash);
        }
      }
      return 0;
    }
    else{
      return -2;

    }

  }

  public boolean find(String word){
    int hash =  hashFunc(word);
    int a = 0;
    while(a <= amount){
      a++;
      if (hashArr[hash].equals(word)){
        return true;
      }
      else{
        hash = reHash(hash);
      }
      if (hashArr[hash] == null){
        return false;
      }
    }
    return false;
  }

  private int reHash(int hash){
    hash += 1;
    hash %= amount;
    return hash;}

  private int hashFunc(String word){
    if (word.length() >= 3){
      char[] chars = word.toCharArray();
      int result = 0;
      for (int i = 0; i < 3; i++ ) {
        result += chars[i];
      }
      return result % this.amount;
    }
    else{
      return -1;
    }
  }
}

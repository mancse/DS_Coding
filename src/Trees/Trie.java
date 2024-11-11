package Trees;
class TrieNode
{
	private TrieNode[] links;
	private boolean isEnd;
	public TrieNode()
	{
		links = new TrieNode[26];
	}
	
	public void setEnd()
	{
		isEnd = true;
	}
	
	public boolean getEnd()
	{
		return isEnd;
	}
	
	public void put(char ch, TrieNode node)
	{
		links[ch -'a'] = node;
	}
	
	public TrieNode get(char ch)
	{
		return links[ch - 'a'];
	}
	
	public boolean containsKey(char ch)
	{
		return links[ch - 'a'] != null;
	}
}

public class Trie 
{
    private TrieNode root;
    
    public Trie()
    {
    	root = new TrieNode();
    }
    
    public void insert(String word)
    {
    	TrieNode node = root;
    	
    	for (int i=0 ; i < word.length() ; i++)
    	{
    		char ch = word.charAt(i);
    	    if (!node.containsKey(ch))
    	    {
    	    	node.put(ch, new TrieNode());
    	    }
    	    node = node.get(ch);
    	    if (i == word.length() -1)
    	    {
    	    	node.setEnd();
    	    }
    	}
        
    }
    
    public TrieNode searchPrefix(String word)
    {
    	TrieNode node = root;
    	
    	for (int i=0 ; i < word.length() ; i++)
    	{
    		char ch = word.charAt(i);
    		
    		if (!node.containsKey(ch))
    		{
    			return null;
    		}
    		else
    		{
    			node = node.get(ch);
    		}
    	}
    	
    	return node;
    }
    
    public boolean search (String word)
    {
    	TrieNode node = searchPrefix(word);
        return (node != null && node.getEnd());
    }
    
    public boolean startswith (String word)
    {
    	TrieNode node = searchPrefix(word);
    	return node != null;
    }
    
    public static void main(String args[])
    {
    	Trie trie = new Trie();
    	
    	trie.insert("computer");
    	trie.insert("common");
    	trie.insert("people");
    	
    	System.out.println("computer lies in trie: "+trie.search("computer"));
    	System.out.println("common lies in trie: "+trie.search("common"));
    	System.out.println("people lies in trie: "+trie.search("people"));
    	System.out.println("peop lies in trie: "+trie.search("peop"));
    	System.out.println("computer starts with com: "+trie.startswith("com"));
    	System.out.println("computer starts with com: "+trie.startswith("bo"));
    }
}

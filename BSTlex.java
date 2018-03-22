//ID: 126 87 26
//NAME: Liam Barclay


public class BSTlex
{
	//A object of type BST will have contain a word and two pointers to the child BST.
	private String data;
	private BSTlex leftTree;
	private BSTlex rightTree;

	public void BSTlex()
	{
		//left and right tree are not defined in the constructor as this would result in a recursive object.
	}

	//Returns a boolean value and is given a string.
	//Returns true if the string d is found in the current BST.
	public boolean find(String d)
	{
		//If current BST has null data, return false as data can not be found.
		if(data == null) { return false; }
		
		//returns true if data is found
		if(data.equals(d))
		{
			return true;
		}
	
		//if the string evaluates to less than the current BST's data
		//Continue looking for the string in the leftTree
		if(d.compareTo(data) < 0)
		{
			//Check if left tree is null, if true means not found so return false
			if(leftTree == null)
			{		
				return false;
			}	
			//Otherwise keep looking in the left tree
			return leftTree.find(d);
		}

		//Otherwise the string must evaluates greater than the current BST's data
		//So continue looking for the string in the rightTree
		else
		{
			//Check if right tree is null, if true means not found so return false
			if(rightTree == null)
			{		
				return false;
			}	
			//Otherwise keep looking in the right tree
			return rightTree.find(d);
		}
	}


	//Method to insert a given string into the current BST at the appropriate location.
	public void insert(String d)
	{
		//If the current data is null
		if(data == null)
		{
			//Set the data to word we want to insert
			//print the data and return.
			data = d;
			System.out.print(data + " ");
			return;
		}
		
		//Print the current data before continuing the insert
		System.out.print(data + " ");

		//If d should be inserted in the left tree
		if(d.compareTo(data) < 0)
		{
			//if left tree is null, make a left tree.
			if(leftTree == null)
			{
				leftTree = new BSTlex();
			}
			//insert the data into the left tree
			leftTree.insert(d);
		}
		//otherwise d should be inserted in the right tree
		else
		{
			//If the right tree is null, make a new right tree
			if(rightTree == null)
			{
				rightTree = new BSTlex();
			}
			//insert the data into the right tree
			rightTree.insert(d);
		}
	}

	//Method to traverse and print the bst in order
	public void traverse()	
	{
		//If the data is null, return
		if(data == null) { return; }
		//If the left tree is not null
		if(leftTree != null)
		{
			//Traverse the left tree
			leftTree.traverse();
		}
		//Print the current data
		System.out.println(data);
		//if the right tree is not null
		if(rightTree != null)
		{
			//Traverse the right tree.
			rightTree.traverse();
		}

	}

	//Returns a string that is from the left most data from the current BST
	public String leftMost()
	{
		//if there are not more left trees, return the data of current bst
		if (leftTree == null)
		{
			return data;
		}
		//Otherwise find the leftmost data from the leftTree of the current bst.
		else
		{
			return leftTree.leftMost();
		}
	}

	//Remove a given string from the BST
	public void remove(String d)
	{
		//return if current data is null, no BST exists
		if(data == null) { return; }
		//if data equal d, this bst has no parent
		if(data.equals(d))
		{
			//print the data then make this data equal the leftmost data along the right tree
			System.out.print(data + " ");
			this.data = rightTree.leftMost();
			//Then remove that left most bst
			rightTree.remove(this.data, this);
		}
		//Otherwise find and remove the data in this tree
		else
		{
			remove(d, this);
		}
	}

	//Remove method to remove a string d when given a branch of a bst to remove from (parent)
	public void remove(String d, BSTlex parent)
	{
		//Print the data of the BST
		System.out.print(data + " ");
		//d is less than the data of the current bst
		if(d.compareTo(data) < 0)
		{
			//if left tree is null, return
			if(leftTree == null)
			{
				return;
			}
			//remove the d from the left Tree
			else
			{
				leftTree.remove(d, this);
				return;
			}
		}
		//else if d is greater than the data of the current bst
		else if(d.compareTo(data) > 0)
		{
			//if the right tree is null, return
			if(rightTree == null)
			{
				return;
			}
			//otherwise remove d from the right tree
			else
			{
				rightTree.remove(d, this);
				return;
			}
		}
		//else this d must be equal to data
		else
		{
			//if the current bst has a left and right tree
			if (leftTree != null && rightTree != null) 
			{
				//copy the data from the left most bst from the right tree
				this.data = rightTree.leftMost();
				//then remove the bst from where we copied the data
				rightTree.remove(this.data, this);
            } 
			//otherwise if this is the left tree it parent
			else if (parent.leftTree == this) 
			{
				//if the lefttree is not null, make our parents left tree point to our left tree
				if(leftTree != null)
				{
					parent.leftTree = leftTree;
				}
				//otherwise make our parents left tree point to our right tree
				else
				{
					parent.leftTree = rightTree;
				}


            } 
			//otherwise if we are from the right tree of a bst
			else if (parent.rightTree == this) 
			{
				//if our lefttree is not null, make our parents right tree point to our left tree
				if(leftTree != null)
				{
					parent.rightTree = leftTree;
				}
				//otherwise make our parents right tree point to our right tree
				else
				{
					parent.rightTree = rightTree;
				}
            }
		}
	}

	






































}

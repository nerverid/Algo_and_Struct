#include <stdio.h>
#include <stdlib.h>
struct node
{
   int data;
   struct  node *leftChild;
   struct  node *rightChild;
};

struct node* newNode(int data)
{
   struct node* node = (struct node*)malloc(sizeof(struct node));
   node -> data = data;
   
   node->leftChild = Null;
   node->rightChild = Null;
   return(node);    
} 

int main(int argc, char *argv[])
{
  struct node *root = newNode(1);
  
  root->leftChild = newNode(2);
  root->rightChild = newNode (3);
  
  root->leftChild->leftChild = newNode(4);
  
  getChar();
  
  system("PAUSE");	
  return 0;
}

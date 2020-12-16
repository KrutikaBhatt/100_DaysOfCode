#include <iostream>
using namespace std;
// Defines the structure of Node in linked list
class Node{
  public: int data;

  // XOR of next and previous node
  Node *npx;
};

Node * XOR(Node *a,Node *b){
  // convert one pointer of another pointer of any type
  return reinterpret_cast<Node *>(reinterpret_cast<uintptr_t>(a) ^reinterpret_cast<uintptr_t>(b)); 
}
Node *head = NULL;

void add(int data){
  Node *new_node = new Node();
  new_node -> data =data;
  new_node ->npx = head;

  if(head!=NULL){
    (head)->npx = XOR(new_node,head->npx);
  }

  head = new_node;
}

void print_list(){
  if(head == NULL){
    cout<<"The list is empty";
  }
  else{
    Node *current = head;
    Node *prev = NULL;
    Node *next;

    cout<< "The linked List is displayed below :";

    // Traverse throught the Linked List
    while(current != NULL){
      cout<<(current->data)<<" ";
      next = XOR(prev,current->npx);
      
      prev = current;
      current = next;
    }
  }
}

int get(int index){
  if(head == NULL){
    cout << "List is empty Error :";
    return 404;
  }
  else{
    int i=0;
    Node *current = head;
    Node *prev = NULL;
    Node *next;

    // Traverse throught the Linked List
    while(current != NULL ){
      
      if(i==(index-1)){
        return (current->data);
      }
      next = XOR(prev,current->npx);
      
      prev = current;
      current = next;
      
      i++;

    }
    cout<< "Index out of sie of list . Error :";
    return 404;
  }
}

int main() {
  
  add(10); 
  add(20); 
  add(30); 
  add(40);

  print_list (); 
  cout<<"\nEnter the index of the node you want :";

  int index;
  cin>>index;
  {
  cout<<"\nElement at index "<< index<< " is "<< get(index);
  }
}
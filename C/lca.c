//This programme finds the least common ansestor of given two nodes in a binary search tree
#include<Stdio.h>
#include<stdlib.h>

struct node{
	int data;
	struct node* left;
	struct node* right;
};

//Recursive function to find LCA of n1 and n2. The function assumes that both n1 and n2 
//are present in the bst
struct node* lca(struct node* root, int n1, int n2){
	
	if(root == NULL) return NULL;

	//if both n1 and n2 are smaller than root, then LCA lies in left
	if(root->data > n1 && root->data > n2)
		return lca(root->left, n1, n2);

	//if both n1 and n2 are larger than root, then LCA lies in right
	if(root->data < n1 && root->data < n2)
		return lca(root->right, n1, n2);
	
	return root;
}

//Iterative function to find LCA
struct node* iter_lca(struct node* root, int n1, int n2){

	if(root == NULL) return NULL;

	while(root != NULL){
		if(root->data > n1 && root->data > n2)
			root = root->left;
		else if(root->data < n1 && root->data < n2)
			root = root->right;
		else
			break;
	}
	return root;
}

//Helper function that allocates a new node with the given data
struct node* newNode(int data){
	
	struct node* node = (struct node*)malloc(sizeof(struct node));

	node->data = data;
	node->left = node->right = NULL;
	return node;
} 

/*Driver programme to test lca()*/
int main(){
	//Let us construct the bst first
	struct node* root = newNode(20);
	root->left = newNode(8);
	root->right = newNode(22);
	root->left->left = newNode(4);
	root->left->right = newNode(12);
	root->left->right->left = newNode(10);
	root->left->right->right = newNode(14);

	int n1 = 10, n2 = 14;
	struct node* t = iter_lca(root, n1, n2);
	printf("LCA of %d and %d is %d\n", n1, n2, t->data);

	n1 = 14, n2 = 8;
	t = iter_lca(root, n1, n2);
	printf("LCA of %d and %d is %d\n", n1, n2, t->data);
	
	n1 = 10, n2 = 22;
	t = iter_lca(root, n1, n2);
	printf("LCA of %d and %d is %d\n", n1, n2, t->data);

	getchar();
	return 0;
}

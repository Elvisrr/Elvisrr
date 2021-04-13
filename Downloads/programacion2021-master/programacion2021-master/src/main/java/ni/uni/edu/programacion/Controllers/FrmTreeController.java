/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import ni.uni.edu.programacion.views.FrmTreeDemo;

/**
 *
 * @author Sistemas-12
 */
public final class FrmTreeController {
    private FrmTreeDemo frmTreeDemo;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;
    
    public FrmTreeController(FrmTreeDemo frmTreeDemo){
        this.frmTreeDemo=frmTreeDemo;
        initComponent();
    }

       
    public void initComponent(){
        root = new DefaultMutableTreeNode("Accounting", true);
        treeModel = new DefaultTreeModel(root);
        
        frmTreeDemo.getTreeAccount().setModel(treeModel);
        
        frmTreeDemo.getBtnAdd().addActionListener((e)-> {btnAddActionListener(e);
        
    });
}
    public void btnAddActionListener(ActionEvent e){
        TreePath treePath = frmTreeDemo.getTreeAccount().getSelectionPath();
        if(treePath == null){
            return;
        }
        DefaultMutableTreeNode node =(DefaultMutableTreeNode)treePath.getLastPathComponent();
        String accountName =JOptionPane.showInputDialog(null,"Account name","Imput Dialog", JOptionPane.INFORMATION_MESSAGE);
        
        node.insert(new DefaultMutableTreeNode(accountName), node.getChildCount());
    }
    
    private void btnRemoveActionListener(ActionEvent e){
DefaultMutableTreeNode node=getSelectedNode();
if(node == null){
return;
}
treeModel.removeNodeFromParent(node);


}

}
    

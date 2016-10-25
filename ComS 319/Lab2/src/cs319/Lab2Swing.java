package cs319;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Lab2Swing extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-31,51
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab2Swing frame = new Lab2Swing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	public Lab2Swing() throws FileNotFoundException {
		setTitle("Tabbed Swing Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBounds(6, 6, 438, 266);
		contentPane.add(tabbedPane);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("List", null, panel_3, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tree", null, panel_2, null);
		panel_2.setLayout(null);

		//JTree tree = new JTree();
		DefaultTreeModel t = new DefaultTreeModel(new DefaultMutableTreeNode("Animals") {
			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("Mammals");
				node_1.add(new DefaultMutableTreeNode("Human"));
				node_1.add(new DefaultMutableTreeNode("Kangaroo"));
				node_1.add(new DefaultMutableTreeNode("Elephant"));
				node_1.add(new DefaultMutableTreeNode("Goat"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("Reptiles");
				node_1.add(new DefaultMutableTreeNode("Lizard"));
				node_1.add(new DefaultMutableTreeNode("Boa"));
				node_1.add(new DefaultMutableTreeNode("Iguana"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("Birds");
				node_1.add(new DefaultMutableTreeNode("Duck"));
				node_1.add(new DefaultMutableTreeNode("Pigeon"));
				node_1.add(new DefaultMutableTreeNode("Turkey"));
				node_1.add(new DefaultMutableTreeNode("Goose"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("Insects");
				node_1.add(new DefaultMutableTreeNode("Termite"));
				node_1.add(new DefaultMutableTreeNode("Ladybug"));
				node_1.add(new DefaultMutableTreeNode("Fly"));
				node_1.add(new DefaultMutableTreeNode("Ant"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("Fish");
				node_1.add(new DefaultMutableTreeNode("Sword Fish"));
				node_1.add(new DefaultMutableTreeNode("Shark"));
				node_1.add(new DefaultMutableTreeNode("Eel"));
				add(node_1);
			}
		});
		JTree tree = new JTree(t);
		JScrollPane scrollPane1 = new JScrollPane(tree);
		scrollPane1.setBounds(6, 6, 405, 161);
		panel_2.add(scrollPane1);

		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(94, 185, 117, 29);
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String animalName = JOptionPane.showInputDialog(panel_3, "What is the new animal?", null);
				if (animalName != null) {
					// Identify the node that has been selected
					DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if (selected == null)
						return;

					// add a new node as the last child of the selected node
					t.insertNodeInto(new DefaultMutableTreeNode(animalName), selected, selected.getChildCount());

					// Lets also expand the tree to show the new node
					// Find the array of nodes that make up the path from the root
					// to the newly added node
					TreeNode[] nodes = t.getPathToRoot(selected.getChildAt(selected.getChildCount() - 1));

					// Create a tree path with these nodes
					TreePath path = new TreePath(nodes);
					// Make the entire path visible and make the scroller to move to
					// the last path component
					tree.scrollPathToVisible(path);
				}
			}
		});
		panel_2.add(btnAdd_1);

		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.setBounds(219, 185, 117, 29);
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Identify the node that has been selected
				DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (selected == null)
					return;

				// Identify the parent of the selected node; we are not allowing
				// the root node to be removed
				if (selected.getParent() == null)
					return;

				// User the models remove method to remove the selected node
				t.removeNodeFromParent(selected);
			}
		});
		panel_2.add(btnRemove_1);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		tabbedPane.addTab("Table", null, panel_1, null);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { contentPane }));

		DataModel dataModel = new DataModel();
		panel_3.setLayout(null);
		JList<String> myList = new JList<String>();
		myList.setModel(dataModel);
		JScrollPane scrollPane = new JScrollPane(myList);
		scrollPane.setBounds(72, 5, 260, 132);
		myList.setSelectionBackground(Color.YELLOW);
		myList.setSelectionForeground(Color.BLACK);
		panel_3.add(scrollPane);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(105, 165, 75, 29);
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String companyName = JOptionPane.showInputDialog(panel_3, "What is the new company?", null);
				if (companyName != null) {
					try {
						dataModel.add(companyName);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		panel_3.add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(186, 165, 117, 29);
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dataModel.remove(myList.getSelectedIndex());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_3.add(btnRemove);
	}
}

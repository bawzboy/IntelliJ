package posts;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

/**
 * @author fred
 *
 */
public class ModelChangeSupport {

	/**
	 * 
	 */
	protected final PropertyChangeSupport changeSupport ;

	
	/**
	 * 
	 */
	public ModelChangeSupport() {
		super();
		changeSupport = new PropertyChangeSupport(this);
	}


	/**
	 * @param listener
	 */
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * @param listener
	 */
	public void removePropertyChangeListener(final PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}
}

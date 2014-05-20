/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.springapp.domain.handler;

/**
 * @author Israel Garcia Centeno
 */
public class MalformedHandlerException extends RuntimeException{
    
	private static final long serialVersionUID = 1L;

	public MalformedHandlerException(String msg) {
        super(msg);
    }
}

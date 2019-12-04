<<<<<<< HEAD
package expression;

import program.IProgram;
import visitors.IExprVisitor;

public class LesserThanEqualToExpression extends Expression implements IBinaryExpression {

	private IExpression mLHS;
	private IExpression mRHS;
	
	public LesserThanEqualToExpression(IProgram program, IExpression lhs, IExpression rhs) throws Exception {
		super(program, Type.BOOLEAN);
		if(lhs.getType() != rhs.getType()) {
			Exception e = new Exception("LesserThanEqualToExpression : Type error.");
			throw e;
		}
		this.mLHS = lhs;
		this.mRHS = rhs;
	}

	public IExpression getLHS() {
		return this.mLHS;
	}

	public IExpression getRHS() {
		return this.mRHS;
	}

	@Override
	public String toString() {
		return "(" + this.mLHS.toString() + " <= " + this.mRHS.toString() + ")";
	}

	@Override
	public void accept(IExprVisitor<?> visitor) {
		try {
			visitor.visit(this.mRHS);
			visitor.visit(this.mLHS);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
=======
package expression;

import program.IProgram;
import visitors.IExprVisitor;

public class LesserThanEqualToExpression extends Expression implements IBinaryExpression {

	private IExpression mLHS;
	private IExpression mRHS;
	
	public LesserThanEqualToExpression(IProgram program, IExpression lhs, IExpression rhs) throws Exception {
		super(program, Type.BOOLEAN);
		if(lhs.getType() != rhs.getType()) {
			Exception e = new Exception("LesserThanEqualToExpression : Type error.");
			throw e;
		}
		this.mLHS = lhs;
		this.mRHS = rhs;
	}

	public IExpression getLHS() {
		return this.mLHS;
	}

	public IExpression getRHS() {
		return this.mRHS;
	}

	@Override
	public String toString() {
		return "(" + this.mLHS.toString() + " <= " + this.mRHS.toString() + ")";
	}

	@Override
	public void accept(IExprVisitor<?> visitor) {
		try {
			visitor.visit(this.mRHS);
			visitor.visit(this.mLHS);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
>>>>>>> 25ebf124fd450adaed57ee1006dedb1a7734bcf9

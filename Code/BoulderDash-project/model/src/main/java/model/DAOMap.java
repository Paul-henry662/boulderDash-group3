package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import contract.IElement;
import model.element.motionless.BreakableBrick;
import model.element.motionless.Diamond;
import model.element.motionless.MotionlessFactory;
import model.element.motionless.Rock;
import model.element.motionless.UnBreakableBrick;

/**
 * The Class DAOMap.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
class DAOMap extends DAOEntity<Map> {

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMap(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final Map entity) {
		String sql = "{call createMap(?,?,?,?,?)}";
		String elementString = "";
		
		try {
			CallableStatement call = this.getConnection().prepareCall(sql);
			
			for(int y=0; y<entity.getHeight(); y++) {
				for(int x=0; x<entity.getWidth(); x++) {
					IElement elmnt = entity.getOnTheMapXY(x, y);
					
					if(elmnt instanceof UnBreakableBrick)
						elementString+="U";
					else if(elmnt == null)
						elementString+="b";
					else if(elmnt instanceof BreakableBrick)
						elementString+="B";
					else if(elmnt instanceof Diamond)
						elementString+="D";
					else if(elmnt instanceof Rock)
						elementString+="R";
				}
			}
			
			call.setInt(1, entity.getId());
			call.setString(2, entity.getKey());
			call.setInt(3, entity.getWidth());
			call.setInt(4, entity.getHeight());
			call.setString(5, elementString);
			
			call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final Map entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	@Override
	public boolean update(final Map entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	@Override
	public Map find(final int id) {
		Map map = new Map();
		String sql = "{call findMapById(?)}";
		
		try {
			CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			
			final ResultSet resultSet = call.getResultSet();
			
			if (resultSet.first()) {
				char[] elements = resultSet.getString("elements").toCharArray();
				map.setId(id);
				map.setKey(resultSet.getString("name"));
				map.setWidth(resultSet.getInt("width"));
				map.setHeight(resultSet.getInt("height"));
				
				
				for(int y=0; y<map.getHeight(); y++) {
					for(int x=0; x<map.getWidth(); x++)
						map.setOnTheMapXY(MotionlessFactory.getFromFileSymbol(elements[x]), x, y);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	@Override
	public Map find(final String code) {
		return null;
	}

}

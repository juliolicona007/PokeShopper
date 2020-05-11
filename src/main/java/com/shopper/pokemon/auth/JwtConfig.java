package com.shopper.pokemon.auth;

public class JwtConfig {
	public static final String NAME_APP = "pokeShopperApp";
			
	public static final String PASSWORD_APP = "shopper2020";
	
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEAufkqGN0ZGahKQIPDx0x12o9E9+4Gz1RsOCdzUkwSl304SwjG\r\n" + 
			"oMfBvcBu/aMyYTjOLkeTU1GlkS8vo1dFmn6Kyvigz5cAasbqxoYJQiUdGROcgN5y\r\n" + 
			"qcZrdip4Yi/HQNVbUlEzDxNFW9P5SwQXLjTH0TZlyU9g2KzsVOGnATMck2aM+Jsy\r\n" + 
			"7xE9lSH/nqgQySm3DHT2gDFTyvclU9PrEI1NqVYm6Hpl+Mjyyr6gd/+XKrkHAup9\r\n" + 
			"GVx3SHT4Bx0B0u/XAyLUIrdDqSuoIh2TkihxOTwyCxR0wg5Yz5K7Gw50T0oO9Yah\r\n" + 
			"xo9c3FTHRzLAIs68v8wr1m2r8+btpqkAVdCs+wIDAQABAoIBACJ6VRmi8+JT1uA7\r\n" + 
			"DXLHdBn+8bRdRpntdtq6RaD+RXwcVPFkQR7RqdN595nCRbbMhz0BPAj4XA+cheJs\r\n" + 
			"bZUE3Mpgab/SqNsi4afIdbLzmn9pqVwi4XMkPAv+N69MWE5mv7V1JFgpJHSvycnk\r\n" + 
			"ij+gvWLGCPzXYIcLGA1sgD+ysBuLWI8/6hPWcbfOM4UoAbu90qxLTJPD+RpceGpf\r\n" + 
			"O4HqRKLIlBB+zSbqkxU0GC9gXiBBb20yWyTSbXhuwOahHZjWVE77ot8+jFGoR9tf\r\n" + 
			"sdMYxlTked+Sak89KHedRUR+W4idhT5cRcJCHE/K6olNT9ghhwwClv4G2dT92byr\r\n" + 
			"WzRJBSECgYEA54s/VFrfoweBqs4kFklroay7kvh27CqNaKnnTN6N0W1CzPGYyURg\r\n" + 
			"AKYaee4ZjfXPTCmLT3WaF9moSrXDbDSWce3Tbi1RKTYeWobgJ+fAdU5gC57ebVEW\r\n" + 
			"E+bZ8cIid0ra5k/mUD80+AbzGyMTWrm6RnskgEl5Ao19h9TPu45oQTMCgYEAzZ25\r\n" + 
			"uq5PPMlh5OeIre+iItBoKrQBbzRq277KfLZHqMvqamsgiNIVC5muXH0pIhkm7HoD\r\n" + 
			"hEvy3qKVss8YWNqRldqGsFvv/oxoVepNyanC7x0ocwg0+mKcfp/eD89tW3l6CKpQ\r\n" + 
			"YGSXJctTjHKBjtiC2AAZ2SIMz5UGcBdFsoTSdRkCgYEAzbeu/ZB7j4pUz1+1OkPj\r\n" + 
			"J9KjGPI+Hpez6aDCy04UbFSJ/DJOz8s7DHiHn3tHIxSZKA7lIiTXUodkeXRCe3nB\r\n" + 
			"jNmDdyk2KcpWb5HTyECkgtSuisSM1E0ts2LwklYsbxaHpAarFvMBabgq+BpS0NGg\r\n" + 
			"yYwRIxWkOPti43LVWcstn3cCgYEAoXXUrdJJKJuewshJ3QQK1rm+wqG9apzHuK0W\r\n" + 
			"hl4A4XzXJB/hWW9W1Vglwj0KetszZIjfkBivq8ISOWpEXSmtHvaNw5k+WS3alHS8\r\n" + 
			"BrrG90t3QvVT3LZo20ogb1vcLPO0L2/GVBtJUYVbozMbp5c/D+zsX0RMuQj2GDk+\r\n" + 
			"ItQIC6kCgYB9t7zIWyc93LESugZJnY9v9ABpKf6RWO8MLF+yK7+4oYV6mFyq+qrf\r\n" + 
			"gp1lfSQhqKTB4kpU5OhX5CBeWVRCzKMkC55LV+S2YlfSAmxnP+4i5OAKWBXGXeVs\r\n" + 
			"2HVw6TkGSuA/zQd/zoVwgs2kM8JT98oTtM0M0dVEwxK6/hTA7+UTnw==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAufkqGN0ZGahKQIPDx0x1\r\n" + 
			"2o9E9+4Gz1RsOCdzUkwSl304SwjGoMfBvcBu/aMyYTjOLkeTU1GlkS8vo1dFmn6K\r\n" + 
			"yvigz5cAasbqxoYJQiUdGROcgN5yqcZrdip4Yi/HQNVbUlEzDxNFW9P5SwQXLjTH\r\n" + 
			"0TZlyU9g2KzsVOGnATMck2aM+Jsy7xE9lSH/nqgQySm3DHT2gDFTyvclU9PrEI1N\r\n" + 
			"qVYm6Hpl+Mjyyr6gd/+XKrkHAup9GVx3SHT4Bx0B0u/XAyLUIrdDqSuoIh2Tkihx\r\n" + 
			"OTwyCxR0wg5Yz5K7Gw50T0oO9Yahxo9c3FTHRzLAIs68v8wr1m2r8+btpqkAVdCs\r\n" + 
			"+wIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}

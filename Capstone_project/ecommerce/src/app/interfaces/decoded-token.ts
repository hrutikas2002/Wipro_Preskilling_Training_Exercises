export interface DecodedToken {
  sub: string; // usually the username
  role: string; // roles inside token (USER, ADMIN)
  exp: number;
}

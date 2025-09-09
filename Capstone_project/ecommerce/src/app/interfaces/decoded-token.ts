export interface DecodedToken {
  sub: string;      // username like "rutika24"
  role?: string;
  id?: number;      // <-- numeric user id from JWT
  exp?: number;
  iat?: number;
}

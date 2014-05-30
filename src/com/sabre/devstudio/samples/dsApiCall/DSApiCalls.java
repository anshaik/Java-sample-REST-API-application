/*
 * Sabre Inc. All rights reserved.
 * 
 * THE SOFTWARE, SAMPLE CODES AND ANY COMPILED PROGRAMS CREATED USING THE
 * SOFTWARE ARE FURNISHED "AS IS" WITHOUT WARRANTY OF ANY KIND, INCLUDING BUT
 * NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE. NO ORAL OR WRITTEN INFORMATION OR ADVICE GIVEN BY SABRE,
 * ITS AGENTS OR EMPLOYEES SHALL CREATE A WARRANTY OR IN ANY WAY INCREASE THE
 * SCOPE OF THIS WARRANTY, AND YOU MAY NOT RELY ON ANY SUCH INFORMATION OR
 * ADVICE. SABRE DOES NOT WARRANT, GUARANTEE, OR MAKE ANY REPRESENTATIONS
 * REGARDING THE USE, OR THE RESULTS OF THE USE, OF THE SOFTWARE, COMPILED
 * PROGRAMS CREATED USING THE SOFTWARE, OR WRITTEN MATERIALS IN TERMS OF
 * CORRECTNESS, ACCURACY, RELIABLITY, CURRENTNESS, OR OTHERWISE. THE ENTIRE RISK
 * AS TO THE RESULTS AND PERFORMANCE OF THE SOFTWARE AND ANY COMPILED
 * APPLICATIONS CREATED USING THE SOFTWARE IS ASSUMED BY YOU. BY YOUR USE, YOU
 * AGREE THAT NEITHER SABRE NOR ANYONE ELSE WHO HAS BEEN INVOLVED IN THE
 * CREATION, PRODUCTION OR DELIVERY OF THE SOFTWARE SHALL BE LIABLE FOR ANY
 * DIRECT, INDIRECT, CONSEQUENTIAL, OR INCIDENTAL DAMAGES (INCLUDING DAMAGES FOR
 * LOSS OF BUSINESS PROFITS, BUSINESS INTERRUPTION, LOSS OF BUSINESS
 * INFORMATION, AND THE LIKE) ARISING OUT OF THE USE OF OR INABILITY TO USE SUCH
 * PRODUCT EVEN IT SABRE HAS BEEN ADVISED OF THE POSSIBLITY OF SUCH DAMAGES.
 * THIS SOFTWARE IS OWNED AND COPYRIGHTED BY SABRE OR ITS THIRD PARTY SUPPLIERS.
 * YOUR LICENSE TO UTILIZE IT CONFERS NO OWNERSHIP RIGHTS IN THE SOFTWARE OR
 * THOSE PORTIONS YOU MAY USE IN A PROJECT. YOU AGREE TO INDEMNIFY AND HOLD
 * HARMLESS SABRE AND ITS AFFILIATES FOR ANY CLAIM BROUGHT AGAINST IT BASED UPON
 * YOUR USE OF THE SOFTWARE OR ANY COMPILED PROGRAMS CREATED USING THE SOFTWARE
 */
package com.sabre.devstudio.samples.dsApiCall;
import org.apache.commons.codec.binary.Base64;

public class DSApiCalls {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//
		//Request authentication
		//
		final String clientId = "";//Put Your Client Id Here
		final String clientSecret= "";//Put Your Secret Id Here
		
		//base64 encode clientId and clientSecret
        String encodedClientId = Base64.encodeBase64String((clientId).getBytes());
        String encodedClientSecret = Base64.encodeBase64String((clientSecret).getBytes());

        //Concatenate encoded client and secret strings, separated with colon
        String encodedClientIdSecret = encodedClientId+":"+encodedClientSecret;

        //Convert the encoded concatenated string to a single base64 encoded string.
        encodedClientIdSecret = Base64.encodeBase64String(encodedClientIdSecret.getBytes());
		
		DSCommHandler dsC = new DSCommHandler();
		String token = dsC.getAuthToken("https://api.test.sabre.com",encodedClientIdSecret);
		String response = dsC.sendRequest("https://api.test.sabre.com/v1/shop/themes", token);
		//Display the response String
		System.out.println("SDS Response: "+response);
		
		//Other Example Calls
		//Call Destination Finder, for flights from Las Vegas and 5 day Length
		//String response2 = dsC.sendRequest("https://api.test.sabre.com/v1/shop/flights/fares?origin=LAS&lengthofstay=5", token);
		//Display the String
		//System.out.println("SDS Response: "+response2);

	}

}

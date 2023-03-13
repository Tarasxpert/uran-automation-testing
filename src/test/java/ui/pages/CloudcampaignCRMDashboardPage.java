package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class CloudcampaignCRMDashboardPage {
    private final SelenideElement dashboardButton = $x("//div[@id = \"controls_dashboard\"]");
    private final SelenideElement userAccountNameButton = $x("//span[@class=\"inverse\"]");
    private final SelenideElement postNowButton = $x("//div[@id=\"controls_broadcast\"]");
    private final SelenideElement textAreaInPostNow = $x("//textarea[@id=\"content_text_area\"]");
    private final SelenideElement publishButton = $x("//button[@ng-click=" +
            "\"broadcastContent(contentBeingEdited);\"]");
    private final SelenideElement successTextAfterPublish = $x("//p[contains" +
            "(@ng-bind, 'broadcastSuccessText')][not(normalize-space(.)='')]");
    private final ElementsCollection userDropdownMenuButton = $$x("//ul[@id = \"user_settings_menu\"]" +
            "/li/a");
    private final ElementsCollection userInfoList = $$x("//form[@id=\"user_settings_section\"]" +
            "/table/tbody/tr");
    private final ElementsCollection chooseAccountList = $$x("//table[@class=\"padded-table\"]" +
            "/tbody/tr[@ng-click= \"togglePostContentAccount(contentBeingEdited, account)\"]");

    @Step("Checking if Dashboard is visible")
    public boolean isDisplayedDashboardButton() {
        return dashboardButton.isDisplayed();
    }

    @Step("Clicking User account drop-down menu in top right corner of the page")
    public void clickUserAccountNameButton() {
        userAccountNameButton.click();
    }

    @Step("Choosing 'Account settings'")
    public void clickToAccountSettingsButton() {
        userDropdownMenuButton.findBy(text("Account Settings")).click();
    }

    @Step("Clicking 'Post Now' button")
    public void clickPostNowButton() {
        postNowButton.click();
    }

    @Step("Clicking 'Twitter' button in choose accounts in 'Post now'")
    public void clickToTwitterInChooseAccounts() {
        chooseAccountList.findBy(text("Twitter")).click();
    }

    @Step("Clicking 'Publish' button in 'Post now'")
    public void clickToPublishButton() {
        publishButton.click();
    }

    @Step("Inputting text in are in 'Post now'")
    public void inputTextAreaInPostNow(String text) {
        textAreaInPostNow.setValue(text);
    }

    @Step("Checking if the success text appeared")
    public String getTextFromSuccessTextAfterPublish() {
        return successTextAfterPublish.should(visible, Duration.ofSeconds(30)).getText();
    }

    @Step("Checking if the role of account 'admin'")
    public String getTextFromUserRoleText() {
        return userInfoList.findBy(text("admin")).getText();
    }
}